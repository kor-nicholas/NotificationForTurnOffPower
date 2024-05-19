from aiogram.dispatcher.filters.state import StatesGroup, State

class Change(StatesGroup):
    name = State()
    surname = State()
    dataofbirthday = State()
    city = State()
    address = State()

class Delete(StatesGroup):
    agree = State()

class Register(StatesGroup):
    name = State()
    surname = State()
    dataofbirthday = State()
    city = State()
    address = State()