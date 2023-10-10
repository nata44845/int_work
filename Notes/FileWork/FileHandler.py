import json
import pickle


class FileHandler:

    def write(self, serializable, fileName):
        try:
            with open(fileName, "wb") as fp:
                pickle.dump(serializable, fp)
        except Exception as e:
            print(e)
            return False
        return True

    def read(self, fileName):
        try:
            with open(fileName, "rb") as fp:
                data = pickle.load(fp)
                return data
        except Exception as e:
            print(e)
            return None
