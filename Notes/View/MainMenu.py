from View.Commands.GetInfo import GetInfo
from View.Commands.AddItem import AddItem
from View.Commands.EditData import EditData
from View.Commands.RemoveItem import RemoveItem
from View.Commands.SaveData import SaveData
from View.Commands.LoadData import LoadData
from View.Commands.Finish import Finish

from View.Commands.SortByHeader import SortByHeader
from View.Commands.SortByDate import SortByDate
from View.Commands.ClearData import ClearData


class MainMenu:

    def __init__(self, consoleUI):
        self.commandList = []
        self.commandList.append(GetInfo(consoleUI))
        self.commandList.append(AddItem(consoleUI))
        self.commandList.append(EditData(consoleUI))
        self.commandList.append(RemoveItem(consoleUI))
        # self.commandList.append(SortByHeader(consoleUI))
        # self.commandList.append(SortByDate(consoleUI))
        # self.commandList.append(ClearData(consoleUI))
        self.commandList.append(SaveData(consoleUI))
        self.commandList.append(LoadData(consoleUI))

        self.commandList.append(Finish(consoleUI))

    def menu(self):
        sb = ""
        for i in range(len(self.commandList)):
            sb += str(i+1)
            sb += ". "
            sb += self.commandList[i].getDescription()
            sb += "\n"
        return sb

    def execute(self, choice):
        command = self.commandList[choice-1]
        command.execute()

    def getSize(self):
        return len(self.commandList)
