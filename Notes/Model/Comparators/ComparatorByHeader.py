class ComparatorByHeader(tuple):

    def compare(o1, o2):
        return o1.getHeader().compareTo(o2.getHeader())
