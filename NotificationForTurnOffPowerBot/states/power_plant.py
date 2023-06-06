from aiogram.dispatcher.filters.state import StatesGroup, State

class Add_power_plant(StatesGroup):
    name = State()
    count_of_power = State()