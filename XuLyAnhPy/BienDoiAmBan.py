import cv2
import matplotlib.pyplot as plt
import numpy as np

def invert_image(image):
    return 255 - image

def convert_to_negative_and_display(input_path):
    # Đọc ảnh bằng OpenCV
    original_image = cv2.imread(input_path)

    # Chuyển đổi thành ảnh âm bản
    negative_image = invert_image(original_image)

    # Hiển thị ảnh gốc và ảnh âm bản
    plt.subplot(1, 2, 1)
    plt.imshow(cv2.cvtColor(original_image, cv2.COLOR_BGR2RGB))
    plt.title("Original Image")

    plt.subplot(1, 2, 2)
    plt.imshow(cv2.cvtColor(negative_image, cv2.COLOR_BGR2RGB))
    plt.title("Negative Image")

    plt.show()

if __name__ == "__main__":
    input_image_path = 'images/cat.jpg'

    convert_to_negative_and_display(input_image_path)
