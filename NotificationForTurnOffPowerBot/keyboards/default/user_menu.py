from aiogram.types import ReplyKeyboardMarkup, KeyboardButton

user_manu_keyboard = ReplyKeyboardMarkup(
    keyboard=[
        [
            KeyboardButton('Змінити'),
            KeyboardButton('Видалити')
        ]
    ], resize_keyboard=True
)