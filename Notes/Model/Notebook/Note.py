import datetime


class Note():

    def __init__(self, id, name, text):
        self.id = id
        self.name = name
        self.createdAt = datetime.datetime.now()
        self.text = text

    def getId():
        return id

    def setId(self, id):
        self.id = id

    def getFullInfo(self,):
        return self.id+' '+self.name+' '+self.createdAt+' '+self.text

    def getDate(self):
        return self.createdAt
