from aiogram import types
from aiogram.dispatcher.filters.builtin import CommandStart
from aiogram.dispatcher import FSMContext

from loader import dp

from keyboards.default.start_keyboard import start_keyboard

@dp.message_handler(CommandStart())
async def bot_start(message: types.Message):
    await message.answer('Привіт, друже🖐\n\nЩо будемо робити ?', reply_markup=start_keyboard)

    


    
    
