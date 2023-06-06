import requests
from requests.exceptions import JSONDecodeError

from aiogram import types

from loader import dp

from states.users import Delete
from states.users import Change
from states.users import Register

from keyboards.default.agree_to_delete_user import agree_to_delete_user
from keyboards.default.user_menu import user_manu_keyboard

from handlers.users.start import bot_start

@dp.message_handler(content_types=['text'])
async def handler_all_text(message: types.Message):
    if message.text == 'Змінити':
        await message.answer('Введіть нове ім\'я')
        await Change.name.set()
    elif message.text == 'Видалити':
        await message.answer('Ви впевнені, що хочете видалити обліковий запис?', reply_markup=agree_to_delete_user)
        await Delete.agree.set()
    elif message.text == 'В головне меню':
        await login(message=message)
    elif message.text == 'Реєстрація':
        await message.answer('Реєстрація')
        await message.answer('Введіть ваше ім\'я')
        await Register.name.set()
    elif message.text == 'Вхід':
       await login(message=message)
    elif message.text == 'Прив\'язати сайт':
        await message.answer(f'Для того, щоб прив\'язати бот до сайту, введіть даний telegram id <code>{message.chat.id}</code> на сайті')
        await bot_start(message=message)
    else:
        await message.answer('Не знайдено такої кнопки. Використайте кнопку нижче 👇', reply_markup=user_manu_keyboard)

async def login(message: types.Message):
    responce = requests.get(f'http://localhost:8080/users/getByTelegramId/{message.chat.id}')
    try:
        user = responce.json()
        await message.answer(f'<b>Обліковий запис</b>:\n\n{user["name"]} {user["surname"]}\nДата народження: {user["dateofbirthday"]}\nВік: {user["age"]}\nМісто: {user["city"]}', reply_markup=user_manu_keyboard)
    except JSONDecodeError:
        await message.answer('Виникла помилка. Можливо ви не зареєстровані в системі')


