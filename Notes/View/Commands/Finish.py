from View.Commands.Command import Command


class Finish(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Закончить работу"

    def execute(self):
        self.consoleUI.finish()
