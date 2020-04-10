<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
        <body>
            <table border="1" width="100%" style="text-align: center; font-size: 20px;">
                <tr>
                    <th>Author</th>
                    <th>Book Name</th>
                    <th>ISBN</th>
                </tr>

                <xsl:for-each select="library/books/book">
                    <xsl:variable name="authorKey">
                        <xsl:value-of select="authorId"/>
                    </xsl:variable>

                    <xsl:choose>
                        <xsl:when test="isHardcover='true'">
                            <tr style="background-color: red;">
                                <td><font color="white"><xsl:for-each select="/library/authors/author[id=$authorKey]">
                                    <xsl:value-of select="lastName"/>, <xsl:value-of select="firstName"/>
                                </xsl:for-each></font></td>
                                <td><font color="white"><xsl:value-of select="name"/></font></td>
                                <td><font color="white"><xsl:value-of select="isbn"/></font></td>
                            </tr>
                        </xsl:when>
                        <xsl:otherwise>
                            <tr style="background-color: blue;">
                                <td><font color="white"><xsl:for-each select="/library/authors/author[id=$authorKey]">
                                    <xsl:value-of select="lastName"/>, <xsl:value-of select="firstName"/>
                                </xsl:for-each></font></td>
                                <td><font color="white"><xsl:value-of select="name"/></font></td>
                                <td><font color="white"><xsl:value-of select="isbn"/></font></td>
                            </tr>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>