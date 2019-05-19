<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">
                    table.tfmt {
                    border: 1px ;
                    }

                    td.colfmt {
                    border: 1px ;
                    color: red;
                    text-align:right;
                    }

                    th {
                    background-color: black;
                    color: red;
                    }

                </style>
            </head>
            <body>
                <div style="color:red;">
                    <h2>Guns</h2>
                </div>
                <table border="3">
                <tr bgcolor="#2E9AFE">
                    <th style="width:250px">Model</th>
                    <th style="width:250px">Handy</th>
                    <th style="width:250px">Origin</th>
                    <th style="width:250px">Material</th>
                    <th style="width:250px">RangeType</th>
                    <th style="width:250px">Range</th>
                    <th style="width:250px">Sightseeing range</th>
                    <th style="width:250px">Clip</th>
                    <th style="width:250px">Optics</th>
                </tr>
                    <xsl:for-each select="guns/gun">
                        <tr>
                            <td><xsl:value-of select="model"/></td>
                            <td><xsl:value-of select="handy"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td><xsl:value-of select="material"/></td>
                            <td><xsl:value-of select="ttc/rangetype"/></td>
                            <td><xsl:value-of select="ttc/range"/></td>
                            <td><xsl:value-of select="ttc/sightseeingRange"/></td>
                            <td><xsl:value-of select="ttc/clipped"/></td>
                            <td><xsl:value-of select="ttc/optical"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>