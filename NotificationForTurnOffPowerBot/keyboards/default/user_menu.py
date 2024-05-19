from aiogram.types import ReplyKeyboardMarkup, KeyboardButton

user_manu_keyboard = ReplyKeyboardMarkup(
    keyboard=[
        [
            KeyboardButton('Почати отримувати сповіщення')
        ],
        [
            KeyboardButton('Змінити'),
            KeyboardButton('Видалити')
        ],
        [
            KeyboardButton('Графік відключень')
        ],
        [
            KeyboardButton('Назад')
        ]
    ], resize_keyboard=True
)