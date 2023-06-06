import requests

from aiogram import types
from aiogram.dispatcher import FSMContext

from loader import dp

from data.config import ADMINS

from states.power_plant import Add_power_plant

from handlers.users.start import bot_start

@dp.message_handler(commands=['add_power'])
async def add_power(message: types.Message):
    if f'{message.chat.id}' in ADMINS:
        await message.answer('Додавання електроєнергії до станцій')
        await message.answer('Введіть назву електростанції, якій ви хочете додати електроєнергії')
        await Add_power_plant.name.set()
    else:
        await message.answer('Вам недоступна дана команда')

@dp.message_handler(content_types=['text'], state=Add_power_plant.name)
async def add_power_name(message: types.Message, state: FSMContext):
    await state.update_data(name=message.text)
    await message.answer('Введіть кількість енергії')
    await Add_power_plant.count_of_power.set()

@dp.message_handler(content_types=['text'], state=Add_power_plant.count_of_power)
async def add_power_count_of_power(message: types.Message, state: FSMContext):
    await state.update_data(count_of_power=message.text)
    data = await state.get_data()
    await state.finish()

    headers = {
        'Content-Type': 'application/json'
    }

    body = {
        'name': data['name'],
        'countofpower': data['count_of_power'],
    }

    responce = requests.put('http://localhost:8080/powerplant/changeCountOfPower', headers=headers, json=body)

    if responce.status_code == 200:
        await message.answer('Кількість енергії змінена')
    else:
        await message.answer('Сталася помилка. Спробуйте пізніше ще раз')

    await bot_start(message=message)

