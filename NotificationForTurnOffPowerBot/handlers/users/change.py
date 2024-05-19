import requests

from aiogram import types
from aiogram.dispatcher import FSMContext

from loader import dp

from states.users import Change

from keyboards.default.main_menu import go_to_main_menu

@dp.message_handler(content_types=['text'], state=Change.name)
async def change_name(message: types.Message, state: FSMContext):
    await state.update_data(name=message.text)

    await message.answer('Введіть нове прізвище')
    await Change.surname.set()

@dp.message_handler(content_types=['text'], state=Change.surname)
async def change_surname(message: types.Message, state: FSMContext):
    await state.update_data(surname=message.text)

    await message.answer('Введіть нову дату народження в форматі yyyy-mm-dd')
    await Change.dataofbirthday.set()

@dp.message_handler(content_types=['text'], state=Change.dataofbirthday)
async def change_dateofbirthday(message: types.Message, state: FSMContext):
    await state.update_data(dataofbirthday=message.text)

    await message.answer('Введіть нове місто')
    await Change.city.set()

@dp.message_handler(content_types=['text'], state=Change.city)
async def change_city(message: types.Message, state: FSMContext):
    await state.update_data(city=message.text)

    await message.answer('Введіть нову адресу')
    await Change.address.set()

@dp.message_handler(content_types=['text'], state=Change.address)
async def change_address(message: types.Message, state: FSMContext):
    await state.update_data(address=message.text)

    data = await state.get_data()
    await state.finish()

    # headers = {
    #     "Content-Type": "application/json"
    # }
    #
    # body = {
    #     "name": data['name'],
    #     "surname": data['surname'],
    #     "telegramid": message.chat.id,
    #     "dateofbirthday": data['dataofbirthday'],
    #     "city": data['city'],
    # }
    #
    # responce = requests.put('http://localhost:8080/users/changeUserByTelegramId', headers=headers, json=body)
    #
    # if responce.status_code == 200:
    #     await message.answer('Ваш обліковий запис було змінено', reply_markup=go_to_main_menu)
    # else:
    #     await message.answer('Сталася помилка. Спробуйте ще раз пізніше', reply_markup=go_to_main_menu)

    await message.answer('Ваш обліковий запис було змінено', reply_markup=go_to_main_menu)

