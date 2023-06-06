import asyncio
import requests
from requests.exceptions import JSONDecodeError

from aiogram import types
from aiogram.utils.exceptions import ChatNotFound

from loader import dp

from data.config import ADMINS

async def get_telegram_ids_and_notification(message: types.Message):
    while True:
        headers = {
            'Content-Type': 'application/json'
        }

        responce = requests.get('http://localhost:8080/power/getTelegramIdsToNotification', headers=headers)

        try:
            telegram_ids = responce.json()

            if telegram_ids != []:
                for telegram_id in telegram_ids:
                    await message.bot.send_message(telegram_id, 'На електростанціях вашого міста недостатня кількість електроенергії. Можливо скоро у вас вимкниться світло. Краще поставте на зарядку ваші пристрої, щоб вони були заряджені')
                    print(f'Повідомлення про вимкнення світла було відправлено {telegram_id}')
        except JSONDecodeError:
            print('Сталася помилка при збиранні telegramIds для відправки повідомлення')
        except ChatNotFound:
            print('Чат користувача не було знайдено')

        # await asyncio.sleep(3600)
        await asyncio.sleep(10)

@dp.message_handler(commands=['start_notification'])
async def start_notification(message: types.Message):
    if f'{message.chat.id}' in ADMINS:
        asyncio.get_event_loop().create_task(get_telegram_ids_and_notification(message))
    else:
        await message.answer('Дана команда вам не доступна')
    