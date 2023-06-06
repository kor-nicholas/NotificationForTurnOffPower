from aiogram.types import ReplyKeyboardMarkup, KeyboardButton

go_to_main_menu = ReplyKeyboardMarkup(
    keyboard=[
        [
            KeyboardButton('В головне меню')
        ]
    ], resize_keyboard=True
)