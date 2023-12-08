import cv2
import matplotlib.pyplot as plt
import numpy as np

def apply_opening(input_path):
    # Đọc ảnh từ đường dẫn
    image = cv2.imread(input_path, cv2.IMREAD_GRAYSCALE)

    # Tạo kernel cho phép toán opening
    kernel = np.ones((5, 5), np.uint8)

    # Áp dụng phép toán erosion sau đó là dilation (Opening)
    opened_image = cv2.morphologyEx(image, cv2.MORPH_OPEN, kernel)

    # Hiển thị ảnh gốc và ảnh sau khi áp dụng opening
    plt.figure(figsize=(10, 5))

    plt.subplot(1, 2, 1)
    plt.imshow(image, cmap='gray')
    plt.title('Original Image')

    plt.subplot(1, 2, 2)
    plt.imshow(opened_image, cmap='gray')
    plt.title('Opened Image')

    plt.show()

if __name__ == "__main__":
    input_image_path = 'images/moon.jpg'
    apply_opening(input_image_path)
