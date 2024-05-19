import asyncio

import requests
from requests.exceptions import JSONDecodeError

from aiogram import types

from keyboards.default.main_menu import go_to_main_menu
from loader import dp

from states.users import Delete
from states.users import Change
from states.users import Register

from keyboards.default.agree_to_delete_user import agree_to_delete_user
from keyboards.default.user_menu import user_manu_keyboard

from handlers.users.start import bot_start

@dp.message_handler(content_types=['text'])
async def handler_all_text(message: types.Message):
    if message.text == 'Змінити':
        await message.answer('Введіть нове ім\'я')
        await Change.name.set()
    elif message.text == 'Видалити':
        await message.answer('Ви впевнені, що хочете видалити обліковий запис?', reply_markup=agree_to_delete_user)
        await Delete.agree.set()
    elif message.text == 'В головне меню' or message.text == 'Вхід':
        await login(message=message)
    elif message.text == 'Реєстрація':
        await message.answer('Реєстрація')
        await message.answer('Введіть ваше ім\'я')
        await Register.name.set()
    elif message.text == 'Назад':
        await bot_start(message=message)
    elif message.text == 'Графік відключень':
        await message.answer('Графік відключень за адресою вул. Героїв Дніпра, 14, кв. 1\n\n20.05.2024 з ..:.. до ..:.. не буде світла\n\n21.05.2024 з ..:.. до ..:.. не буде світла\n\n<b>22.05.2024</b> з ..:.. до ..:.. не буде світла\n\n23.05.2024 з ..:.. до ..:.. не буде світла\n\n24.05.2024 з ..:.. до ..:.. не буде світла\n\n25.05.2024 з ..:.. до ..:.. не буде світла\n\n26.05.2024 з ..:.. до ..:.. не буде світла', reply_markup=go_to_main_menu)
    elif message.text == 'Почати отримувати сповіщення':
        await message.answer('Тепер у разі скорого відключення світла ви будете відразу отримувати сповіщення про це, щоб ви встигли підготуватись до відключення світла', reply_markup=go_to_main_menu)
        await asyncio.sleep(10)
        await message.answer('У вашому будинку скоро відключиться світло, тому зарядіть всі ваші пристрої, щоб комфортніше перечекати цей час')
    else:
        await message.answer('Не знайдено такої кнопки. Використайте кнопку нижче 👇', reply_markup=user_manu_keyboard)

async def login(message: types.Message):
    # responce = requests.get(f'http://localhost:8080/users/getByTelegramId/{message.chat.id}')
    # try:
    #     user = responce.json()
    #     await message.answer(f'<b>Обліковий запис</b>:\n\n{user["name"]} {user["surname"]}\nДата народження: {user["dateofbirthday"]}\nВік: {user["age"]}\nМісто: {user["city"]}', reply_markup=user_manu_keyboard)
    # except JSONDecodeError:
    #     await message.answer('Виникла помилка. Можливо ви не зареєстровані в системі')

    await message.answer(f'<b>Обліковий запис</b>:\n\nKolya Korovchenko\nДата народження: 2002-12-18\nВік: 21\nМісто: Київ\nАдреса: вул. Героїв Дніпра, 14, кв. 1', reply_markup=user_manu_keyboard)



