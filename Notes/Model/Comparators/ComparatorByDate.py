class ComparatorByDate(tuple):

    def compare(o1, o2):
        return o1.getDate().compareTo(o2.getDate())
