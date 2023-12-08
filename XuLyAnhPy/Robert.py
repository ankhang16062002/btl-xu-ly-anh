import cv2
import numpy as np
import matplotlib.pyplot as plt

def apply_roberts_operator(input_path):
    # Đọc ảnh từ đường dẫn
    image = cv2.imread(input_path, cv2.IMREAD_GRAYSCALE)

    # Tạo kernel cho phép toán Roberts
    kernel_x = np.array([[1, 0], [0, -1]], dtype=np.float32)
    kernel_y = np.array([[0, 1], [-1, 0]], dtype=np.float32)

    # Áp dụng phép toán Roberts
    roberts_x = cv2.filter2D(image, -1, kernel_x)
    roberts_y = cv2.filter2D(image, -1, kernel_y)

    # Tính toán độ lớn của đạo hàm
    roberts_magnitude = np.sqrt(np.square(roberts_x) + np.square(roberts_y))

    # Hiển thị ảnh gốc và kết quả
    plt.figure(figsize=(12, 4))

    plt.subplot(1, 4, 1)
    plt.imshow(image, cmap='gray')
    plt.title('Original Image')

    plt.subplot(1, 4, 2)
    plt.imshow(roberts_x, cmap='gray')
    plt.title('Roberts X')

    plt.subplot(1, 4, 3)
    plt.imshow(roberts_y, cmap='gray')
    plt.title('Roberts Y')

    plt.subplot(1, 4, 4)
    plt.imshow(roberts_magnitude, cmap='gray')
    plt.title('Roberts Magnitude')

    plt.show()

if __name__ == "__main__":
    input_image_path = 'images/cat.jpg'
    apply_roberts_operator(input_image_path)
