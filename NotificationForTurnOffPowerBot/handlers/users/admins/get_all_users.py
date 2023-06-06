import requests
from requests.exceptions import JSONDecodeError

from aiogram import types

from loader import dp

from data.config import ADMINS

@dp.message_handler(commands=['get_all_users'])
async def get_all_users(message: types.Message):
    if f'{message.chat.id}' in ADMINS:
        headers = {
            'Content-Type': 'application/json'
        }

        responce = requests.get('http://localhost:8080/users/getAll', headers=headers)
        users_str = '<b>Всі користувачі</b>: \n\n'

        try:
            users = responce.json()

            if users != []:
                for user in users:
                    users_str += f'{user["name"]} {user["surname"]}\n'
                    users_str += f'Дата народження: {user["dateofbirthday"]}\n'
                    users_str += f'Вік: {user["age"]}\n'
                    users_str += f'Місто: {user["city"]}\n\n'
            
            await message.answer(users_str)
        except JSONDecodeError:
            await message.answer('Сталася помилка. Спробуйте пізніше')
    else:
        await message.answer('Дана команда вам не доступна')

