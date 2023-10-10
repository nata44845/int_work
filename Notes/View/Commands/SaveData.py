from View.Commands.Command import Command


class SaveData(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Сохранить данные"

    def execute(self):
        self.consoleUI.saveData()
