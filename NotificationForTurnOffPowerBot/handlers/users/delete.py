import requests

from aiogram import types
from aiogram.dispatcher import FSMContext

from loader import dp

from states.users import Delete

from keyboards.default.main_menu import go_to_main_menu

@dp.message_handler(content_types=['text'], state=Delete.agree)
async def check_agree_to_delete_user(message: types.Message, state: FSMContext):
    if message.text == 'Так':
        # responce = requests.delete(f'http://localhost:8080/users/deleteByTelegramId/{message.chat.id}')
        #
        # if responce.status_code == 200:
        #     await message.answer('Ваш обліковий запис було видалено', reply_markup=go_to_main_menu)
        # else:
        #     await message.answer('Сталася помилка. Спробуйте ще раз пізніше', reply_markup=go_to_main_menu)

        await message.answer('Ваш обліковий запис було видалено', reply_markup=go_to_main_menu)
    elif message.text == 'Ні':
        await message.answer('Ми дуже раді, що ви залишились з нами 🥺', reply_markup=go_to_main_menu)
    else:
        await message.answer('Немає такого вибору. Спробуйте ще раз', reply_markup=go_to_main_menu)
    
    await state.finish()