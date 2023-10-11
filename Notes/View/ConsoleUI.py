from FileWork.FileHandler import FileHandler
from Presenter.Presenter import Presenter
from View.MainMenu import MainMenu
import re


class ConsoleUI:
    INPUT_ERROR = "Вы ввели неверное значение"

    def __init__(self):
        self.presenter = Presenter(self, FileHandler())
        self.work = True
        self.menu = MainMenu(self)

    def createData(self):
        self.presenter.addItem("Заметка 1", "Текст 1")
        self.presenter.addItem("Заметка 2", "Текст 2")
        self.presenter.addItem("Заметка 3", "Текст 3")

    def printAnswer(self, text):
        print(text)

    def start(self):
        self.hello()
        while self.work:
            self.printMenu()
            self.execute()

    def finish(self):
        print("До свидания")
        self.work = False

    def sortByDate(self):
        print("Сортировка по дате")
        self.presenter.sortByDate()

    def sortByHeader(self):
        print("Сортировка по названию")
        self.presenter.sortByHeader()

    def getInfo(self):
        self.presenter.getInfo()

    def addItem(self):
        print("Добавление данных")
        header = input("Введите название: ")
        body = input("Введите текст заметки: ")
        self.presenter.addItem(header, body)

    def saveData(self):
        print("Сохранение")
        fileName = input("Введите имя файла: ")
        self.presenter.saveData(fileName)

    def loadData(self):
        print("Загрузка")
        fileName = input("Введите имя файла: ")
        self.presenter.loadData(fileName)

    def clearData(self):
        print("Удаление данных")
        question = input("Удалить данные Y/N?")
        if question == "Y":
            self.presenter.clearData()

    def editData(self):
        print("Редактирование записи")
        line = input("Введите номер записи: ")
        if self.checkTextForInt(line):
            numId = int(line)
            self.presenter.editData(numId)
        else:
            self.inputError()

    def editItem(self, note):
        print(note.getFullInfo())
        header = input("Введите название: ")
        body = input("Введите текст заметки: ")
        self.presenter.editItem(note, header, body)

    def removeItem(self):
        print("Удаление заметки")
        self.getInfo()
        line = input("Введите номер заметки: ")
        if self.checkTextForInt(line):
            numId = int(line)
            self.presenter.removeItem(numId)

    def hello(self):
        print("Доброго времени суток!")

    def execute(self):
        line = input()
        if self.checkTextForInt(line):
            numCommand = int(line)
            if self.checkCommand(numCommand):
                self.menu.execute(numCommand)

    def checkTextForInt(self, text):
        if re.match(r"[0-9]+", text):
            return True
        else:
            return False

    def checkCommand(self, numCommand):
        if numCommand <= self.menu.getSize():
            return True
        else:
            self.inputError()
            return False

    def printMenu(self):
        print(self.menu.menu())

    def inputError(self):
        print(self.INPUT_ERROR)
