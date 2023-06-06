from aiogram.types import ReplyKeyboardMarkup, KeyboardButton

agree_to_delete_user = ReplyKeyboardMarkup(
    keyboard=[
        [
            KeyboardButton('Так'),
            KeyboardButton('Ні')
        ]
    ], resize_keyboard=True
)