import tkinter as tk
from tkinter import filedialog, Text
import os
import random
from bs4 import BeautifulSoup
import requests


# The root is like an environment in LATEX or the body in html
root = tk.Tk()


def generate_teams():
    content = requests.get('https://nerdburglars.net/namegenerator/funny-nickname-generator/').content
    so = BeautifulSoup(content, 'html.parser')
    element = so.find('h2')
    print(f"h2: {element}")
    team1 = []
    team2 = []
    members = ['Steak bien grillé', 'Davido Cloutier', 'Alexandre Le Grand', 'The Rain Man']

    titles_persons = ['The Genius', 'Sous chef', 'The Director of Non so Ethical Hacking', 'The Master of Disaster',
                      'The Crayon Evangelist', 'The Ambassador of buzz', 'The Digital Prophet', 'The Chief Cheerleader',
                      'The Dick 8===D', 'The Cockring Wielder', 'Social Media Sith Lord', 'The Penis',
                      'The LL Professional Nudes Hacker', 'The One Who Saw MF In The Eyes And Never Came Back',
                      'The Spacial Gigolot']

    print(len(titles_persons))
    # for member in members:


    for member in range(4):
        if random.randint(0, 1) % 2 == 0:
            if len(team1) < 2:
                team1.append(members[member - 1])
            else:
                team2.append(members[member - 1])
        else:
            if len(team2) < 2:
                team2.append(members[member - 1])
            else:
                team1.append(members[member - 1])

    team_one = 'Team One: ' + team1[0] + ' ' + team1[1]
    team_two = 'Team Two: ' + team2[0] + ' ' + team2[1]

    label_team1 = tk.Label(frame, text=team_one, bg="gray")
    label_team2 = tk.Label(frame, text=team_two, bg="gray")
    label_team1.pack()
    label_team2.pack()


# Creation of the canvas and attach to the root
canvas = tk.Canvas(root, height=500, width=500, bg="#263D42")
# Without this, the dark green canvas wouldn't appear
canvas.pack()

# Creation of the lighter green frame inside the root
frame = tk.Frame(root, bg="green")
# To center it, we had to set: relx=0.1, rely=0.1
frame.place(relwidth=0.8, relheight=0.8, relx=0.1, rely=0.1)

# Creation of the firt button
# Appearance and function
gen_teams = tk.Button(root, text="Generate Teams", padx=10, pady=5, fg="green", bg="#263D42", command=generate_teams)
# Attaching it to the root?
gen_teams.pack()

# runApps = tk.Button(root, text="Run Applications", padx=10, pady=5, fg="green", bg="#263D42")
# runApps.pack()

root.mainloop()
