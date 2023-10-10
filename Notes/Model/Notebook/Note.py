import datetime


class Note:

    def __init__(self, header, body):
        self._header = header
        self._body = body
        self._id = None
        self._createdAt = datetime.datetime.now()
        self._updatedAt = self._createdAt

    def __getstate__(self) -> dict:  # Как мы будем "сохранять" класс
        state = {}
        state["id"] = str(self._id)
        state["header"] = self._header
        state["body"] = self._body
        # state["createdAt"] = self._createdAt
        # state["updatedAt"] = self._updatedAt
        return state

    def __setstate__(self, state: dict):  # Как мы будем восстанавливать класс из байтов
        self._id = state["id"]
        self._header = state["header"]
        self._body = state["body"]
        # self._createdAt = state["createdAt"]
        # self._updatedAt = state["updatedAt"]

    def getId(self):
        return self._id

    def setId(self, id):
        self._id = id

    def getDate(self):
        return self._createdAt

    def getHeader(self):
        return self._header

    def setHeader(self, header):
        self._header = header

    def getBody(self, body):
        self._body = body
        self._updatedAt = datetime.datetime.now()

    def setBody(self, body):
        self._body = body
        self._updatedAt = datetime.datetime.now()

    def getFullInfo(self):
        return str(self._id)+' '+self._header+' '+self._body + ' ' + format(self._createdAt.strftime("%d.%m.%y %H:%M:%S")) + ' ' + format(self._updatedAt.strftime("%d.%m.%y %H:%M:%S"))
