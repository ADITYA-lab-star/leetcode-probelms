def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        n=len(s)
        i=0
        res=""
        while i<n:
            while i<n and s[i]==" ":
                i+=1
            if i>=n:
                break
            j=i+1
            while j<n and s[j]!=" ":
                j+=1
            res=s[i:j]+" "+res
            i=j+1
        return res.strip()