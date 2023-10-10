from View.Commands.Command import Command


class EditData(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Редактировать заметку"

    def execute(self):
        self.consoleUI.editData()
