from View.Commands.Command import Command


class AddItem(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Добавить заметку"

    def execute(self):
        self.consoleUI.addItem()
