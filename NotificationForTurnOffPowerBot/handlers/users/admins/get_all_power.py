import requests
from requests.exceptions import JSONDecodeError

from aiogram import types

from loader import dp

from data.config import ADMINS

@dp.message_handler(commands=['get_all_power'])
async def get_all_power(message: types.Message):
    if f'{message.chat.id}' in ADMINS:

        headers = {
            'Content-Type': 'application/json'
        }

        responce = requests.get('http://localhost:8080/powerplant/getAll', headers=headers)

        try:
            power_plants = responce.json()
            power_plants_str = '<b>Всі електростанції</b>:\n\n'

            if power_plants != []:
                for power_plant in power_plants:
                    power_plants_str += f'Назва: {power_plant["name"]}\n'
                    power_plants_str += f'Місто: {power_plant["city"]}\n'
                    power_plants_str += f'Кількість електроенергії: {power_plant["countofpower"]}\n\n'

            await message.answer(power_plants_str)
        except JSONDecodeError:
            await message.answer('Сталася помилка при зчитуванні електростанції, де встановлені датчики')
    else:
        await message.answer('Дана команда вам не доступна')