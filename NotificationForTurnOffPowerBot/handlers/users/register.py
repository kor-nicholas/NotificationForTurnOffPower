import requests
from datetime import datetime

from aiogram import types
from aiogram.dispatcher import FSMContext

from loader import dp

from handlers.users.text import login

from states.users import Register

@dp.message_handler(content_types=['text'], state=Register.name)
async def register_name(message: types.Message, state: FSMContext):
    await state.update_data(name=message.text)
    await message.answer('Введіть ваше прізвище')
    await Register.surname.set()

@dp.message_handler(content_types=['text'], state=Register.surname)
async def register_surname(message: types.Message, state: FSMContext):
    await state.update_data(surname=message.text)
    await message.answer('Введіть вашу дату народження (yyyy-mm-dd)')
    await Register.dataofbirthday.set()

@dp.message_handler(content_types=['text'], state=Register.dataofbirthday)
async def register_dateofbirthday(message: types.Message, state: FSMContext):
    await state.update_data(dateofbirthday=message.text)

    birthday = datetime.strptime(message.text, '%Y-%m-%d').date()
    today = datetime.now().date()
    years = today.year - birthday.year
    if birthday.month >= today.month and birthday.day > today.day:
        years -= 1

    await state.update_data(age=years)

    await message.answer('Введіть ваше місто')
    await Register.city.set()

@dp.message_handler(content_types=['text'], state=Register.city)
async def register_city(message: types.Message, state: FSMContext):
    await state.update_data(city=message.text)
    data = await state.get_data()
    await state.finish()

    headers = {
        'Content-Type': 'application/json'
    }

    body = {
        'name': data['name'],
        'surname': data['surname'],
        'telegramid': message.chat.id,
        'dateofbirthday': data['dateofbirthday'],
        'age': data['age'],
        'city': data['city'],
    }

    responce = requests.post('http://localhost:8080/users/add', headers=headers, json=body)

    if responce.status_code == 200:
        await message.answer('Ви успішно зареєструвались')
    else:
        await message.answer('Сталася помилка. Спробуйте пізніше')

    await login(message=message)






