from View.Commands.Command import Command


class SortByDate(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Отсортировать список по дате"

    def execute(self):
        self.consoleUI.sortByDate()
