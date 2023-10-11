from Model.Comparators.ComparatorByDate import ComparatorByDate
from Model.Comparators.ComparatorByHeader import ComparatorByHeader


class Notebook:
    def __init__(self):
        self.itemList = []
        self.id = 0
        self.__index = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.__index >= len(self.itemList):
            self.__index = 0
            raise StopIteration
        note = self.itemList[self.__index]
        self.__index += 1
        return note

    def addItem(self, note):
        self.id = self.id + 1
        note.setId(self.id)
        self.itemList.append(note)

    def removeItem(self, id):
        for item in self.itemList:
            if item.getId() == id:
                self.itemList.remove(item)
                return True
        return False

    def getProductList(self):
        return self.itemList

    def getInfo(self):
        sb = ""
        sb += "Список записей: \n"
        for item in self.itemList:
            sb += item.getFullInfo()
            sb += "\n"
        return sb

    def getNotebookSize(self):
        return self.itemList.len

    def getTreeItem(self, number):
        for i in range(self.itemList.len):
            if self.itemList[i].getId() == number:
                return self.itemList[i]
        return None

    # def sortByHeader(self):
    #     self.itemList = sorted(self.itemList, key=ComparatorByHeader)

    # def sortByDate(self):
    #     self.itemList = sorted(self.itemList, key=ComparatorByDate)
