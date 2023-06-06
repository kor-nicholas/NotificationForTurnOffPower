from aiogram.types import ReplyKeyboardMarkup, KeyboardButton

start_keyboard = ReplyKeyboardMarkup(
    keyboard=[
        [
            KeyboardButton('Реєстрація'),
            KeyboardButton('Вхід')
        ],
        [
            KeyboardButton('Прив\'язати сайт')
        ]
    ], resize_keyboard=True
)

