from View.Commands.Command import Command


class LoadData(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Загрузить данные"

    def execute(self):
        self.consoleUI.loadData()
