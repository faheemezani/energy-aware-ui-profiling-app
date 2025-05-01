# Energy-Aware UI Profiling App

This repository hosts the source code for a custom-built Android application developed to support energy profiling experiments related to mobile UI/UX design strategies. The primary objective of this project is to enable controlled and repeatable execution of user interaction scenarios in both **Dark Mode** and **Light Mode** configurations for comparative analysis.

## 🎯 Purpose

The app was designed specifically for academic research on energy-efficient UI/UX patterns in mobile environments. It simulates a simplified e-commerce user journey, including:
- Browsing product listings
- Selecting individual items
- Switching between light and dark visual themes

These scenarios were crafted to support automated performance and energy profiling using tools such as:
- Android Debug Bridge (ADB)
- Bash shell scripting
- Espresso UI testing

## 🧪 Research Context

This application was used as part of a broader experimental framework to measure:
- CPU usage
- Layout rendering time

These metrics were collected during the execution of dark and light mode UI patterns to evaluate their resource efficiency under AMOLED display conditions.

## 🏛 Institutional Affiliation

This research was conducted under the  
**Department of Software Engineering**,  
**Faculty of Information and Communication Technology (FICT)**,  
**Universiti Teknikal Malaysia Melaka (UTeM)**.

## 📄 Associated Publication

Muhammad Faheem M. Ezani, *et al.*,  
“Automated Profiling of Mobile UI/UX Energy Performance: A Comparative Study of Dark and Light Modes,”  
In *Proceedings of AMICT 2025* (Accepted / Under Review).  
(Preprint and dataset: [Zenodo DOI](https://doi.org/10.5281/zenodo.15315445))

## 📂 Folder Structure
```ecommerce/app/``` [source code files & folders for e-commerce based simulation app] 
```results/``` [outputs from the bash shell scripts - also available on Zenodo]
```ecommerce/app/src/androidTest/java/my/edu/utem/faheemezani/``` [Espresso UI automation tests]

## 📜 License

This repository is made publicly available for academic and non-commercial use.  
For citation and reuse, please cite the accompanying paper or dataset as appropriate.

## 🤝 Citation

If you use this repository in your research, please cite:

```bibtex
@misc{faheem2025uiapp,
  author       = {M. E. Muhammad Faheem and I. Muhammad Huzaifah and H. Nor Hafeizah},
  title        = {Energy-Aware UI Profiling App},
  year         = {2025},
  publisher    = {GitHub},
  howpublished = {\url{https://github.com/YOUR_USERNAME/Energy-Aware-UI-Profiling-App}},
  note         = {Used in energy profiling experiments comparing dark and light mode UI designs}
}
