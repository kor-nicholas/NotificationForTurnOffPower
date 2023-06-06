from aiogram import types
from aiogram.dispatcher.filters.builtin import CommandHelp

from loader import dp

from data.config import ADMINS

@dp.message_handler(CommandHelp())
async def bot_help(message: types.Message):
        if f'{message.chat.id}' in ADMINS:
                await message.answer('Список команд:\n/start - Запустити бот\n/help - Отримати список команд\n/add_power - Задати нову кількість електроенергії в електростанції\n/start_notification - почати перевірку кількості та повідомленні у разі потреби\n/get_all_power - Переглянути всі електростанції в яких є датчики та зчитують кількість енергії\n/get_all_users - Вивести список всіх користувачів бота')
        else:
                await message.answer('Список команд:\n/start - Запустити бота\n/help - Отримати список команд')

