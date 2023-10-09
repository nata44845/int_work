import datetime


class Note():

    def __init__(self, id, name, date, text):
        self.id = id
        self.name = name
        self.date = date
        self.text = text

    def getId():
        return id

    def setId(self, id):
        self.id = id

    def getFullInfo(self,):
        return self.id+self.name+self.date+self.text

    def getDate(self):
        return self.date
