from Model.Notebook.Notebook import Notebook
from Model.Notebook.Note import Note


class Presenter:
    def __init__(self, view, fileHandler):
        self.notebook = Notebook()
        self.view = view
        self.fileHandler = fileHandler

    def addItem(self, header, body):
        note = Note(header, body)
        self.notebook.addItem(note)
        return note

    def getInfo(self):
        self.view.printAnswer(self.notebook.getInfo())

    def sortByDate(self):
        self.notebook.sortByDate()
        self.getInfo()

    def sortByHeader(self):
        self.notebook.sortByHeader()
        self.getInfo()

    def getSize(self) -> int:
        return self.notebook.getSize()

    def getItem(self, number):
        return self.notebook.getItem(number)

    def saveData(self, fileName):
        if self.fileHandler.write(self.notebook, fileName):
            self.view.printAnswer("Файл сохранен")
        else:
            self.view.printAnswer("Ошибка сохранения")

    def loadData(self, fileName):
        obj = self.fileHandler.read(fileName)
        if isinstance(obj, Notebook):
            self.notebook = obj
            self.view.printAnswer("Данные загружены")
        else:
            self.view.printAnswer("Ошибка загрузки данных")

    def clearData(self):
        self.notebook = Notebook()
        self.view.printAnswer("Данные удалены")

    def editData(self, id):
        flag = False
        for note in self.notebook:
            if note.getId() == id:
                self.view.editItem(note)
                flag = True
                break
        if flag == False:
            self.view.printAnswer("Данные не найдены")

    def editItem(self, note, header, body):
        note.setHeader(header)
        note.setBody(body)
        self.view.printAnswer("Данные обновлены")

    def removeItem(self, id):
        flag = False
        flag = self.notebook.removeItem(id)
        if flag == True:
            self.view.printAnswer(f"Запись {id} удалена")
        if flag == False:
            self.view.printAnswer("Данные не найдены")
