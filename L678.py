from numpy import var


def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        a=0
        b=0
        c=0

        for i in s:
            if i=='(':
                a+=1
            elif i==')':
                b+=1
            elif i=='*':
                c+=1

        if b>a+c:
            return False
        return True