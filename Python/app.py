import pandas as pd
import plotly_express as px
import streamlit as st

st.set_page_config(page_title='Dashboard', page_icon= ":bar_char:", layout="wide")

df = pd.read_csv('softwareinternship.csv')

# print(df)



st.dataframe(df)

# --------- SIDE BAR ------------
st.sidebar.header("Please Filter Here:")
location = st.sidebar.multiselect(
    "Select the Company:", 
    options=df["Location"].unique(), 
    default=df["Location"].unique()
    )

df_selection = df.query(
    "Location == @location"
)

st.dataframe(df_selection)


#-------MAINPAGE---------
# st.title(":bar_chart: Dashboard")
# st.markdown("##")

# #Top locations
# total_jobs = int(df_selection["Total"].sum())

# left_column = st.columns(1)
# with left_column:
#     st.subheader("Total Jobs")






