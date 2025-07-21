def triangleType(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        a = nums[0]
        b = nums[1]
        c = nums[2]
        if (a + b > c) and (b + c > a) and (c + a > b):
            if a == b and b == c:
                return "equilateral"
            elif a == b or b == c or c == a:
                return "isosceles"
            else:
                return "scalene"
        return "none"
