from View.Commands.Command import Command


class ClearData(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Очистить данные"

    def execute(self):
        self.consoleUI.clearData()
