from View.Commands.Command import Command


class RemoveItem(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Удалить заметку"

    def execute(self):
        self.consoleUI.removeItem()
