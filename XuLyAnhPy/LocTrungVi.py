import cv2
from matplotlib import pyplot as plt

def apply_median_blur_and_display(input_path):
    # Đọc ảnh từ đường dẫn
    image = cv2.imread(input_path, cv2.IMREAD_GRAYSCALE)

    # Áp dụng Median Blur
    blurred_image = cv2.medianBlur(image, 3)

    # Hiển thị ảnh gốc và ảnh sau khi áp dụng Median Blur
    plt.figure(figsize=(10, 5))

    plt.subplot(1, 2, 1)
    plt.imshow(image, cmap='gray')
    plt.title('Original Image')

    plt.subplot(1, 2, 2)
    plt.imshow(blurred_image, cmap='gray')
    plt.title('Blurred Image')

    plt.show()

if __name__ == "__main__":
    input_image_path = 'images/huou.jpg'
    apply_median_blur_and_display(input_image_path)
