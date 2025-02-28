class Solution(object):
    def shortestCommonSupersequence(self, str1, str2):
        """
        :type str1: str
        :type str2: str
        :rtype: str
        """
        if str1 in str2:
            return str2
        if str2 in str1:
            return str1

        m, n = len(str1), len(str2)
        dp = [[""] * (n + 1) for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if str1[i - 1] == str2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + str1[i - 1]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], key=len)

        lcs = dp[m][n]
        i = j = 0
        scs = []

        for c in lcs:
            while str1[i] != c:
                scs.append(str1[i])
                i += 1
            while str2[j] != c:
                scs.append(str2[j])
                j += 1
            scs.append(c)
            i += 1
            j += 1

        scs.extend(str1[i:])
        scs.extend(str2[j:])
        
        return "".join(scs)
