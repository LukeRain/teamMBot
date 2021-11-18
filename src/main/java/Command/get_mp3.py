import sys
import time
from selenium import webdriver
import requests


def downloadfile(name,url):
    name=name+".mp4"
    r=requests.get('url')
    print("****Connected****")
    f=open(name,'wb')
    print("Donloading.....")
    for chunk in r.iter_content(chunk_size=255):
        if chunk: # filter out keep-alive new chunks
            f.write(chunk)
    print("Done")
    f.close()

# Objet webdriver à partir de Firefox
fireFoxOptions = webdriver.FirefoxOptions()
# La ligne suivante fait qu'on aura pas une fenêtre de fureteur qui apparaît
# fireFoxOptions.set_headless()
GECKODRIVER_PATH = "/home/luc/gen_env/bin/geckodriver"

# TEST: next two lines
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
caps = DesiredCapabilities().FIREFOX
# La ligne de code qui suit fait qu'on attend que la page load avant de continuer
caps["pageLoadStrategy"] = "normal"

driver = webdriver.Firefox(executable_path=GECKODRIVER_PATH, firefox_options=fireFoxOptions, capabilities=caps)

input = sys.argv[1]
print(input)

website = 'https://ytmp3.cc/uu46cc/'
driver.get(website)
time.sleep(5)

driver.find_element_by_css_selector('#input').send_keys(input)
time.sleep(5)
driver.find_element_by_css_selector('#submit').click()
time.sleep(5)
link_file = driver.find_element_by_css_selector('#download').get_attribute('href')
downloadfile('sound_file', link_file)



