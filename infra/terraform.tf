terraform {

  required_version = ">=0.12"

  backend "azurerm" {
    resource_group_name  = "rg-azure-tf"
    storage_account_name = "tfstate4711"
    container_name       = "tfstate"
    key                  = "azure-tf.terraform.tfstate"
  }
  
  required_providers {
    azurerm = {
      source = "hashicorp/azurerm"
      version = "~>2.0"
    }
  }
}
