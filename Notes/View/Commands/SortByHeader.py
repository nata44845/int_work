from View.Commands.Command import Command


class SortByHeader(Command):

    def __init__(self, consoleUI):
        super().__init__(consoleUI)
        self.description = "Отсортировать список по названию"

    def execute(self):
        self.consoleUI.sortByHeader()
