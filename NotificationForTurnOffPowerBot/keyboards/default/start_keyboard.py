from aiogram.types import ReplyKeyboardMarkup, KeyboardButton

start_keyboard = ReplyKeyboardMarkup(
    keyboard=[
        [
            KeyboardButton('Реєстрація'),
            KeyboardButton('Вхід')
        ]
    ], resize_keyboard=True
)

