from PyQt5.QtWidgets import *
from PyQt5 import uic
import sys

ui_path = 'calc.ui'
from_class = uic.loadUiType(ui_path)[0]

# print(from_class)

class WindowClass(QMainWindow, from_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

        self.btn_c.clicked.connect(self.btn_cliclked)
        self.btn_0.clicked.connect(self.btn_cliclked)
        self.btn_1.clicked.connect(self.btn_cliclked)
        self.btn_2.clicked.connect(self.btn_cliclked)
        self.btn_3.clicked.connect(self.btn_cliclked)
        self.btn_4.clicked.connect(self.btn_cliclked)
        self.btn_5.clicked.connect(self.btn_cliclked)
        self.btn_6.clicked.connect(self.btn_cliclked)
        self.btn_7.clicked.connect(self.btn_cliclked)
        self.btn_8.clicked.connect(self.btn_cliclked)
        self.btn_9.clicked.connect(self.btn_cliclked)
        self.btn_result.clicked.connect(self.btn_cliclked)
        self.btn_add.clicked.connect(self.btn_cliclked)
        self.btn_min.clicked.connect(self.btn_cliclked)
        self.btn_mul.clicked.connect(self.btn_cliclked)
        self.btn_div.clicked.connect(self.btn_cliclked)

        self.le_view.setEnabled(False)
        self.text_value = ""

    def btn_cliclked(self):
        btn_value = self.sender().text()
        
        if btn_value == "C":
            self.le_view.setText("0")
            self.text_value = ""
        elif btn_value == "=":
            print("=")
            try:
                resultvalue = eval(self.text_value)
                self.le_view.setText(str(resultvalue))  
            except:
                self.le_view.setText("error")
        else:
            if btn_value == "×":
                btn_value = "*"
            self.text_value = self.text_value + btn_value
            self.le_view.setText(self.text_value)
        # print(btn_value)

if __name__=="__main__":
    app = QApplication(sys.argv)
    print(app)
    my_window = WindowClass()
    my_window.show()
    app.exec_()