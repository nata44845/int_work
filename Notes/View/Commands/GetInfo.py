from View.Commands.Command import Command


class GetInfo(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Получить список"

    def execute(self):
        self.consoleUI.getInfo()
